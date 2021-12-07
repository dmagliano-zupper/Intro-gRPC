package br.dev.magliano

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(){

    val request = NovoVeiculoRequest.newBuilder()
        .setAno(2002)
        .setModelo("Zafira")
        .setPlaca("JPL4I25")
        .setTipoCombustivelValue(TipoCombustivel.ALCOOL_VALUE)
        .addProprietario(
            NovoVeiculoRequest.Proprietario.newBuilder()
                .setCpfProprietario("116.722.897-93")
                .setNomeProprietario("Diogo Costa Magliano")
                .build()
        )
        .build()

    println(request)

    request.writeTo(FileOutputStream("novoveiculo.bin"))

    val request2 = NovoVeiculoRequest.newBuilder().mergeFrom(FileInputStream("novoveiculo.bin"))

    request2.setTipoCombustivelValue(TipoCombustivel.FLEX_VALUE)

    println(request2
    )
}