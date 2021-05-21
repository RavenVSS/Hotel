package com.example.hotel.reservation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "guest_id")
    private Integer guestId;

    @Column(name = "worker_id")
    private Integer workerId;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "actual_status")
    @Enumerated(EnumType.STRING)
    private ActualStatus actualStatus;

    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(name = "success_pay_status")
    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    @Column(name = "receipt")
    private Integer receipt;

    @Column(name = "money")
    private Integer money;

    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ActualStatus getActualStatus() {
        return actualStatus;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }

    public Integer getReceipt() {
        return receipt;
    }

    public Integer getMoney() {
        return money;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation() {

    }

    public Reservation(BuilderReservation builderReservation) {
        this.guestId = builderReservation.guestId;
        this.workerId = builderReservation.workerId;
        this.roomId = builderReservation.roomId;
        this.beginDate = builderReservation.beginDate;
        this.endDate = builderReservation.endDate;
        this.actualStatus = builderReservation.actualStatus;
        this.paymentMethodId = builderReservation.paymentMethodId;
        this.payStatus = builderReservation.payStatus;
        this.receipt = builderReservation.receipt;
        this.money = builderReservation.money;
        this.comment = builderReservation.comment;
    }

    public static class BuilderReservation {
        private Integer guestId;
        private Integer workerId;
        private Integer roomId;
        private Date beginDate;
        private Date endDate;
        private ActualStatus actualStatus;
        private Integer paymentMethodId;
        private PayStatus payStatus;
        private Integer receipt;
        private Integer money;
        private String comment;

        public BuilderReservation guestId(Integer value) {
            this.guestId = value;
            return this;
        }

        public BuilderReservation workerId(Integer value) {
            this.workerId = value;
            return this;
        }

        public BuilderReservation roomId(Integer value) {
            this.roomId = value;
            return this;
        }

        public BuilderReservation beginDate(Date value) {
            this.beginDate = value;
            return this;
        }

        public BuilderReservation endDate(Date value) {
            this.endDate = value;
            return this;
        }

        public BuilderReservation actualStatus(ActualStatus value) {
            this.actualStatus = value;
            return this;
        }

        public BuilderReservation paymentMethodId(Integer value) {
            this.paymentMethodId = value;
            return this;
        }

        public BuilderReservation payStatus(PayStatus value) {
            this.payStatus = value;
            return this;
        }

        public BuilderReservation receipt(Integer value) {
            this.receipt = value;
            return this;
        }

        public BuilderReservation money(Integer value) {
            this.money = value;
            return this;
        }

        public BuilderReservation comment(String value) {
            this.comment = value;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}
