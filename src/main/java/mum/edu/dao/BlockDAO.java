package mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Block;
@Transactional(propagation=Propagation.MANDATORY)
public interface BlockDAO extends JpaRepository<Block,Integer>{

}
