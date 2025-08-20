package com.clara.dslist.repositories;

import com.clara.dslist.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;

//Não precisa ser registrado por extender de um componente já registrado
//Aqui será feito os comandos em SQL que será utilizado pelo serviço
public interface GameRepository extends JpaRepository<Games, Long> {

}
