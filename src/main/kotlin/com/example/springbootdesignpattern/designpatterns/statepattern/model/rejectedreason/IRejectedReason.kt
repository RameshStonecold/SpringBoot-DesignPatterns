package com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason

import java.time.LocalDate

interface IRejectedReason {

    fun getRejectedReasonId():RejectedReasonId
    fun getInvoiceId():String?
    fun getReason():String?
    fun getReasonCreatedDate(): LocalDate?
    fun getReasonUpdatedDate(): LocalDate?
}
