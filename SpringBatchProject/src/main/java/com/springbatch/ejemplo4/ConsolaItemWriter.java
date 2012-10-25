/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.springbatch.ejemplo4;

import java.util.Collection;
import java.util.List;
import org.springframework.batch.item.ItemWriter;

/**
 * 
 * @author dciocca
 *
 */
public class ConsolaItemWriter implements ItemWriter {

    public void write(List item) throws Exception {
        Collection<Planeta> col = (Collection<Planeta>) item;
            for (final Planeta planeta : col) {
            System.out.println(planeta.getCodigo() + " - " + planeta.getNombre());
        }
        
    }

}
