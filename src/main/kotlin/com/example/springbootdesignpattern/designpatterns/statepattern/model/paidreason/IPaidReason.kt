package com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason

import java.time.LocalDate

interface IPaidReason {

    fun getPaidReasonId():PaidReasonId
    fun getInvoiceId():String?
    fun getPaidReason():String?
    fun getReasonCreatedDate():LocalDate?
    fun getReasonUpdateDate():LocalDate?
}
