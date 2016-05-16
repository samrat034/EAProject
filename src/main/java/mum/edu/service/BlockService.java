package mum.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.dao.RegistrationDao;
import mum.edu.domain.Block;
import mum.edu.domain.Registration;

public class BlockService {
	@Autowired
    private RegistrationDao registrationDao;

    public List<Block> getBlocks(String username) {
    	List<Registration> registration=registrationDao.findByUser_Username(username);
    	List<Block> block=new ArrayList<Block>();
    	for(int i=0;i<registration.size();i++){
    		block.add(registration.get(i).getBlock());
    	}
       return block; 
    }


}
