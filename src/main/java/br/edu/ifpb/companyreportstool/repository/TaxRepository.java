package br.edu.ifpb.companyreportstool.repository;

import br.edu.ifpb.companyreportstool.domain.Expense;
import br.edu.ifpb.companyreportstool.domain.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {


}
