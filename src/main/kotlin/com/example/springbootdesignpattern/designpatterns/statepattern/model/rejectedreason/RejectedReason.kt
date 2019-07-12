package com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason

import java.time.LocalDate

class RejectedReason(private val rejectedReasonState: RejectedReasonState):IRejectedReason by rejectedReasonState {


    override fun getRejectedReasonId(): RejectedReasonId {
      return  this.rejectedReasonState.getRejectedReasonId()
    }

    override fun getInvoiceId(): String? {
       return this.rejectedReasonState.getInvoiceId()
    }

    override fun getReason(): String? {
        return this.rejectedReasonState.getReason()
    }

    override fun getReasonCreatedDate(): LocalDate? {
     return this.rejectedReasonState.getReasonCreatedDate()
    }

    override fun getReasonUpdatedDate(): LocalDate? {
        return this.rejectedReasonState.getReasonUpdatedDate()
    }

    fun convertToState():RejectedReasonState?{
        return this.rejectedReasonState
    }

}
