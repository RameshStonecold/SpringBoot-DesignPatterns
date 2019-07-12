package com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice


import com.example.springbootdesignpattern.designpatterns.statepattern.model.InvoiceStatus
import com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason.PaidReason
import com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason.RejectedReason
import io.vavr.control.Either
import java.time.LocalDateTime

class StudentInvoice(private val studentInvoiceState: StudentInvoiceState) : IStudentInvoice by studentInvoiceState {

    constructor() : this(StudentInvoiceState())


    override fun getStudentInvoiceId(): StudentInvoiceId {
        return this.studentInvoiceState.getStudentInvoiceId()
    }

    override fun getInvoiceNumber(): String? {
        return this.studentInvoiceState.getInvoiceNumber()
    }

    override fun getInvoiceCreatedDate(): LocalDateTime? {
        return this.studentInvoiceState.getInvoiceCreatedDate()
    }

    override fun getInvoiceUpdatedDate(): LocalDateTime? {
        return this.studentInvoiceState.getInvoiceUpdatedDate()
    }

    override fun getInvoiceStatus(): InvoiceStatus? {
        return this.studentInvoiceState.getInvoiceStatus()
    }

    fun convertToState(): StudentInvoiceState {
        return this.studentInvoiceState
    }


    fun setPaidReason(paidReason: PaidReason?){
        this.studentInvoiceState.setPaidReason(paidReason)
    }
    fun setRejectedReason(rejectedReason: RejectedReason?){
        this.studentInvoiceState.setRejectedReason(rejectedReason)
    }

    fun changeStatusToPaid(paidReason: PaidReason): Either<Exception, Boolean> {
        this.setPaidReason(paidReason)
        return this.studentInvoiceState.getInvoiceStatus()!!.changeStatusToPaid(this)
    }

    fun changeStatusToRejected(rejectedReason: RejectedReason): Either<Exception, Boolean> {
        this.setRejectedReason(rejectedReason)
        return this.studentInvoiceState.getInvoiceStatus()!!.changeStatusToRejected(this)
    }



}
