package com.example.springbootdesignpattern.designpatterns.statepattern.service

import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.PaidReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.RejectedReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.StudentInvoiceDto
import io.vavr.control.Either

interface IStatePatternService {

    fun generateInvoice(studentInvoiceDto: StudentInvoiceDto):Either<Exception,String>

    fun getById(id:String):Either<Exception, StudentInvoiceDto>

    fun changeStatusToPaid(paidReasonDto: PaidReasonDto):Either<Exception,String>

    fun changeStatusToRejected(rejectedReasonDto: RejectedReasonDto):Either<Exception,String>




}
