package br.dev.magliano.veiculo

import br.dev.magliano.NovoVeiculoRequest
import javax.persistence.Entity

@Entity
class Veiculo(

    val modelo : String,
    val placa : String,
    val ano : Int,
    val proprietario: NovoVeiculoRequest.Proprietario

/*    string modelo = 1;
string placa = 2;
int32 ano = 3;

message Proprietario{
    string nomeProprietario = 1;
    string cpfProprietario = 2;
}

repeated Proprietario proprietario = 4;
TipoCombustivel tipoCombustivel =5;*/

) {

}