package com.example.springbootdesignpattern.designpatterns.statepattern.service

import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.PaidReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.RejectedReasonDto
import com.example.springbootdesignpattern.designpatterns.statepattern.model.dto.StudentInvoiceDto
import io.vavr.control.Either
import org.springframework.stereotype.Service

@Service
class StatePatternServiceImpl:IStatePatternService {


    override fun generateInvoice(studentInvoiceDto: StudentInvoiceDto): Either<Exception, String> {
        TODO()
    }

    override fun getById(id: String): Either<Exception, StudentInvoiceDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeStatusToPaid(paidReasonDto: PaidReasonDto): Either<Exception, String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeStatusToRejected(rejectedReasonDto: RejectedReasonDto): Either<Exception, String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
