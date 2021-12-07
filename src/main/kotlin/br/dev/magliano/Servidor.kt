package br.dev.magliano

import com.google.protobuf.Timestamp
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import java.time.LocalDateTime
import java.time.ZoneId

val porta = 50051

fun main() {
    val server = ServerBuilder
        .forPort(porta)
        .addService(VeiculoService())
        .build()

    server.start()
    println("Servidor iniciado na porta $porta")
    server.awaitTermination()
}

class VeiculoService : VeiculoServiceGrpc.VeiculoServiceImplBase(){


    override fun cadastrar(request: NovoVeiculoRequest?, responseObserver: StreamObserver<VeiculoReponse>?) {

        val instant = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant()
        val criadoEm = Timestamp.newBuilder()
            .setSeconds(instant.epochSecond)
            .setNanos(instant.nano)
            .build()

        var id : Int? = null

        if (request != null) {
            if(!request.hasField(NovoVeiculoRequest.getDescriptor().findFieldByName("modelo"))){
                    id = 999
            }
            else {
                id = 123
            }
        }

        val response = id?.let {
            VeiculoReponse.newBuilder()
                .setId(it)
                .setDataCriacao(criadoEm)
                .build()
        }

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }
}