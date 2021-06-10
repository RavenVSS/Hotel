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
    @ApiOperation(value = "Создать новую запись бронирования", nickname = "New reservation")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewReservation (@RequestBody ReservationCreateDto reservationCreateDto) {

        //TODO refactor workerId and receipt
        reservationCreateDto.setWorkerId(authService.getCurrentUserId());
        reservationCreateDto.setReceipt(receiptService.getReceipt(reservationCreateDto.getGuestId(),
                reservationCreateDto.getRoomId()));
        reservationService.create(reservationMapper.fromDto(reservationCreateDto));
    }

    @PostMapping("{id}/update")
    @ApiOperation(value = "Обновить запись бронирования по ID", nickname = "Update reservation")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateReservation (@RequestBody ReservationCreateDto reservationCreateDto,
                                   @PathVariable("id") Integer id) {
        reservationService.update(reservationMapper.fromDto(reservationCreateDto), id);
    }

    @PostMapping("{id}/delete")
    @ApiOperation(value = "Удалить запись бронирования по ID", nickname = "Delete reservation")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReservation(@PathVariable("id") Integer id) {
        reservationService.delete(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Получить запись бронирования по ID", nickname = "Get at reservation")
    public ReservationDto getAtReservation(@PathVariable("id") Integer id) {
        Reservation reservation = reservationService.findAt(id);
        ReservationDto reservationDto = reservationMapper.toDto(reservation);
        return reservationDto;
    }

    @GetMapping("list")
    @ApiOperation(value = "Получить все записи бронирования", nickname = "Get all reservation")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.toList(reservationService.findAll());
    }

    @GetMapping("search/name")
    @ApiOperation(value = "Получить все записи бронирования по имени и фамилии гостя",
            nickname = "Get reservations by name")
    public List<ReservationDto> getReservationsByName(@RequestParam("firstName") String firstName,
                                                      @RequestParam("secondName") String secondName) {
        return reservationMapper.toList(reservationService.findByName(firstName, secondName));
    }

    @GetMapping("search/date")
    @ApiOperation(value = "Получить все записи бронирования по дате приезда", nickname = "Get reservations by date")
    public List<ReservationDto> getReservationsByDate(@RequestParam("beginDate")
                                                      @DateTimeFormat(pattern="yyyy-MM-dd") Date beginDate) {
        return reservationMapper.toList(reservationService.findByBeginDate(beginDate));
    }
}
