/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.springbatch.ejemplo8;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * 
 * @author dciocca
 *
 */
public class ConsolaItemWriter implements ItemWriter<Contact> {

    public void write (List<? extends Contact> items) {
		for (Contact item : items) {
			System.out.println("write() - " + item.toString());
		}
	}
}
