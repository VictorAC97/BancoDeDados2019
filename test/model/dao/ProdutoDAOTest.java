/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Produto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    public void inserir() {
        Produto p = new Produto();
        p.setNome("1T de Ferro");
        
    }
    
}
