package com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason

import java.time.LocalDate

class PaidReason (val paidReasonState: PaidReasonState):IPaidReason by paidReasonState{


    override fun getPaidReasonId(): PaidReasonId {
        return this.paidReasonState.getPaidReasonId()
    }

    override fun getInvoiceId(): String? {
        return this.paidReasonState.getInvoiceId()
    }

    override fun getPaidReason(): String? {
        return this.paidReasonState.getPaidReason()
    }

    override fun getReasonCreatedDate(): LocalDate? {
        return this.paidReasonState.getReasonCreatedDate()
    }

    override fun getReasonUpdateDate(): LocalDate? {
        return this.paidReasonState.getReasonUpdateDate()
    }


    fun convertToState():PaidReasonState{
       return this.paidReasonState
    }


}
