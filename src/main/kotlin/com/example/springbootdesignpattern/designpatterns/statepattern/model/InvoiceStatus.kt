package com.example.springbootdesignpattern.designpatterns.statepattern.model

import com.example.springbootdesignpattern.designpatterns.statepattern.model.invoice.StudentInvoice
import io.vavr.control.Either

enum class InvoiceStatus {


    PENDING {

        override fun changeStatusToRejected(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            studentInvoice.convertToState().setInvoiceStatus(REJECTED)
            return Either.right(true)
        }

        override fun changeStatusToPaid(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            studentInvoice.convertToState().setInvoiceStatus(PAID)
            return Either.right(true)
        }

        override fun changeStatusToPending(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

    },

    PAID {
        override fun changeStatusToPending(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

        override fun changeStatusToPaid(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

        override fun changeStatusToRejected(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }


    },

    REJECTED {
        override fun changeStatusToPending(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

        override fun changeStatusToPaid(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

        override fun changeStatusToRejected(studentInvoice: StudentInvoice): Either<Exception, Boolean> {
            return Either.left(Exception("Unknown State Change Exception"))
        }

    };


    abstract fun changeStatusToPending(studentInvoice: StudentInvoice): Either<Exception, Boolean>

    abstract fun changeStatusToPaid(studentInvoice: StudentInvoice): Either<Exception, Boolean>

    abstract fun changeStatusToRejected(studentInvoice: StudentInvoice): Either<Exception, Boolean>

}
