package br.com.ebac.aninalservice.repositorios;

import br.com.ebac.aninalservice.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT a.nomeReceber, COUNT(a) " +
            "FROM Animal a " +
            "WHERE a.nomeReceber = :nomeReceber " +
            "AND a.dataEntrada BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY a.nomeReceber")
    List<Object[]> contarAnimaisPorFuncionarioNoPeriodo(String nomeReceber, LocalDate dataInicio, LocalDate dataFim);

}
