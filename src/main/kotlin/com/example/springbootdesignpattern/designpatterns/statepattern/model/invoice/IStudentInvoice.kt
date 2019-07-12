package com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice

import com.example.springbootdesignpattern.designpatterns.statepattern.model.InvoiceStatus
import com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason.PaidReason
import com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason.RejectedReason
import java.time.LocalDateTime

interface IStudentInvoice {

    fun getStudentInvoiceId():StudentInvoiceId
    fun getInvoiceNumber():String?
    fun getInvoiceCreatedDate():LocalDateTime?
    fun getInvoiceUpdatedDate():LocalDateTime?
    fun getInvoiceStatus(): InvoiceStatus?
    fun getPaidReason(): PaidReason?
    fun getRejectedReason():RejectedReason?
}
