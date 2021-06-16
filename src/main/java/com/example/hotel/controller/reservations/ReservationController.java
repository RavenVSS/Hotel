package com.example.hotel.controller.reservations;

import com.example.hotel.controller.reservations.dto.in.ReservationCreateDto;
import com.example.hotel.controller.reservations.dto.out.ReservationDto;
import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.service.authentication.AuthenticationService;
import com.example.hotel.service.receipt.ReceiptService;
import com.example.hotel.service.reservations.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("reservations")
@Api(tags = "Reservations", description = "Операции с бронированием")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;
    private final AuthenticationService authService;
    private final ReceiptService receiptService;

    @PostMapping("create")
    @PreAuthorize("hasRole('WORKER') || hasRole('USER')")
    @ApiOperation(value = "Создать новую запись бронирования. Доступ: USER || WORKER", nickname = "New reservation")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewReservation (@RequestBody ReservationCreateDto reservationCreateDto) {
        reservationCreateDto.setWorkerId(authService.getCurrentUserId());
        reservationCreateDto.setReceipt(receiptService.getReceipt(reservationCreateDto.getGuestId(),
                reservationCreateDto.getRoomId()));
        reservationService.create(reservationMapper.fromDto(reservationCreateDto));
    }

    //TODO update only for user reservations
    @PostMapping("{id}/update")
    @PreAuthorize("hasRole('WORKER') || hasRole('USER')")
    @ApiOperation(value = "Обновить запись бронирования по ID. Доступ: USER || WORKER", nickname = "Update reservation")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateReservation (@RequestBody ReservationCreateDto reservationCreateDto,
                                   @PathVariable("id") Integer id) {
        reservationService.update(reservationMapper.fromDto(reservationCreateDto), id);
    }

    @PostMapping("{id}/delete")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Удалить запись бронирования по ID. Доступ: WORKER", nickname = "Delete reservation")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReservation(@PathVariable("id") Integer id) {
        reservationService.delete(id);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Получить запись бронирования по ID. Доступ: WORKER", nickname = "Get at reservation")
    public ReservationDto getAtReservation(@PathVariable("id") Integer id) {
        Reservation reservation = reservationService.findAt(id);
        ReservationDto reservationDto = reservationMapper.toDto(reservation);
        return reservationDto;
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Получить все записи бронирования. Доступ: WORKER", nickname = "Get all reservation")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.toList(reservationService.findAll());
    }

    @GetMapping("search/name")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Получить все записи бронирования по имени и фамилии гостя. Доступ: WORKER",
            nickname = "Get reservations by name")
    public List<ReservationDto> getReservationsByName(@RequestParam("firstName") String firstName,
                                                      @RequestParam("secondName") String secondName) {
        return reservationMapper.toList(reservationService.findByName(firstName, secondName));
    }

    @GetMapping("search/date")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Получить все записи бронирования по дате приезда. Доступ: WORKER", nickname = "Get reservations by date")
    public List<ReservationDto> getReservationsByDate(@RequestParam("beginDate")
                                                      @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate) {
        return reservationMapper.toList(reservationService.findByBeginDate(beginDate));
    }

    @GetMapping("current")
    @PreAuthorize("hasRole('USER') || hasRole('WORKER')")
    @ApiOperation(value = "Получить все записи бронирования текущего пользователя. Доступ: USER || WORKER", nickname = "Get reservations current user")
    public List<ReservationDto> getReservationsCurrentUser() {
        return reservationMapper.toList(reservationService.findByGuestId(authService.getCurrentUserId()));
    }
}
