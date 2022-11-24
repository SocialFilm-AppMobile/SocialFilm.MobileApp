package com.example.socialfilmapp.domain.model

enum class ECategory {
    ACCION,
    COMEDIA,
    DRAMA,
    FANTASIA,
    MUSICAL,
    ROMANCE,
    SCI_FI,
    TERROR,
    THRILLER;

    open fun getValue(): Int {
        return ordinal + 1
    }
}