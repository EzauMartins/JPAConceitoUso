package com.DigitalInnovation.Everis.jpaIntroduction.execute2;

import com.DigitalInnovation.Everis.jpaIntroduction.classes.Aluno;
import com.DigitalInnovation.Everis.jpaIntroduction.classes.Estado;
import org.hibernate.Criteria;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Exec3JPQL {
    public static void main(String[] args) {

       // 1 Dados a serem ultilizados.

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Estado estadoAdicionar = new Estado("Rio De Janeiro","RJ");
        entityManager.persist(estadoAdicionar);
        entityManager.persist(new Estado("Careiro","AM"));
        entityManager.persist(new Aluno("Ezau",24,estadoAdicionar));
        entityManager.persist(new Aluno("Otávio",19,estadoAdicionar));
        entityManager.persist(new Aluno("Pedro",14,estadoAdicionar));
        entityManager.getTransaction().commit();

        //2 = EntityManager.find(),SQL,JPA Critera API, JPQL.


        //=============================================================================
        // Realizar busca (Traz apenas 1 resultado)

      /*  Aluno alunoEntityManager = entityManager.find(Aluno.class, 2);    //entityManager.find(REALIZAR BUSCAS)
        System.out.println("Consulta alunoEntity: " + alunoEntityManager);

        //A busca de multiplos resultados n é possível apenas ultizando os métodos
        //simples, devendo ultilizar os métodos a baixo

        //=============================================================================

        //=============================================================================
        // Busca Com SQL NATIVO.:

        String nome = "Pedro";
       */
            // Retonar 1 resultado

     /*   String sql = "select * from aluno where nome = :nome";
        Aluno alunoSQL = (Aluno) entityManager
                .createNativeQuery(sql, Aluno.class)
                .setParameter("nome",nome)            // OBS = Se n existir o nome do aluno no banco
                .getSingleResult();                      //       retornará erro.



            // Retona Lista como resultado

        String sqlList = "select * from aluno where estado_id = :estadoid";
        List<Aluno> alunoListSql = entityManager
                .createNativeQuery(sqlList, Aluno.class)
                .setParameter("estadoid",2)
                .getResultList();

            // Prints

        //System.out.println("Consulta,um resultado: " + alunoSQL);

        alunoListSql.forEach(Aluno -> System.out.println("Consulta, Mult Resultados: " + Aluno));
*/
        //========================================================================

        //========================================================================


        //JPQL

       /* String nome = "Pedro";

        //---- UM resultado ----
        String jpql = "select a from Aluno a where a.nome = :nome";
        Aluno alunoJPQQL = entityManager
                .createQuery(jpql,Aluno.class)
                .setParameter("nome",nome)
                .getSingleResult();

        // ---- Mult resultado.----

        String jpqlList = "select a from Aluno a where a.estado = :estado";  // obs Nome Da tabela  Maiusculo = ao nome da classe
        List<Aluno> AlunoList = entityManager                                          // é possivel pegar o estado navegando pelos atributos
                .createQuery(jpqlList, Aluno.class)                                         // da classe
                //.setParameter("estadoNome","Rio de Janeiro")
                //.setParameter("estadoid",1)
                .setParameter("estado", entityManager.find(Estado.class,1))
                .getResultList();

        System.out.println("Resultado 1: " + alunoJPQQL);
        System.out.println("=====================================");
        AlunoList.forEach(Aluno -> System.out.println("Resultado 2: "+ Aluno));
        */



    }
}
