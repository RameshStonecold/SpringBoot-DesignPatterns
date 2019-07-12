package com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice


import com.example.springbootdesignpattern.designpatterns.statepattern.model.InvoiceStatus
import com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason.PaidReason
import com.example.springbootdesignpattern.designpatterns.statepattern.model.paidreason.PaidReasonState
import com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason.RejectedReason
import com.example.springbootdesignpattern.designpatterns.statepattern.model.rejectedreason.RejectedReasonState
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Document
class StudentInvoiceState : IStudentInvoice {



    @Id
    private var id:String=UUID.randomUUID().toString()
    private var invoiceNumber:String?=null

    private var invoiceCreatedDate:LocalDateTime?=null

    private var invoiceUpdateDate:LocalDateTime?=null

    @Enumerated(EnumType.STRING)
    private var invoiceStatus: InvoiceStatus?=null

    private var paidReasonState: PaidReasonState?=null

    private var rejectedReasonState: RejectedReasonState?=null

    constructor()


    fun getId():StudentInvoiceId{
        return StudentInvoiceId(this.id)
    }
    fun setId(id:String){
        this.id=id
    }
    override fun getStudentInvoiceId(): StudentInvoiceId {
       return this.getId()
    }
    fun setStudentInvoiceId(id:String){
        this.id=id
    }



    override fun getInvoiceNumber(): String? {
       return this.invoiceNumber
    }
    fun setInvoiceNumber(invoiceNumber: String?){
        this.invoiceNumber=invoiceNumber
    }


    override fun getInvoiceCreatedDate(): LocalDateTime? {
      return this.invoiceCreatedDate
    }
    fun setInvoiceCreatedDate(invoiceCreatedDate: LocalDateTime?){
        this.invoiceCreatedDate=invoiceCreatedDate
    }


    override fun getInvoiceUpdatedDate(): LocalDateTime? {
      return this.invoiceUpdateDate
    }
    fun setInvoiceUpdateDate(invoiceUpdateDate: LocalDateTime?){
        this.invoiceUpdateDate=invoiceUpdateDate
    }

    override fun getInvoiceStatus(): InvoiceStatus? {
       return this.invoiceStatus
    }
    fun setInvoiceStatus(invoiceStatus: InvoiceStatus?){
        this.invoiceStatus=invoiceStatus
    }

    fun setPaidReason(paidReason: PaidReason?){
        this.paidReasonState=paidReason?.convertToState()
    }

    override fun getPaidReason(): PaidReason? {
        if (paidReasonState==null){
            return null
        }
       return PaidReason(this.paidReasonState!!)
    }


    fun setRejectedReason(rejectedReason: RejectedReason?){
        this.rejectedReasonState=rejectedReason?.convertToState()
    }
    override fun getRejectedReason(): RejectedReason? {
        if (rejectedReasonState==null){
            return null
        }
        return RejectedReason(this.rejectedReasonState!!)
    }
}
