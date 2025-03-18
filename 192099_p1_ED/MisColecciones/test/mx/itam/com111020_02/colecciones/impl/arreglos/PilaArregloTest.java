/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.colecciones.impl.arreglos;

import java.util.Collection;
import java.util.Iterator;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertArrayEquals;
import java.lang.Integer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author canof
 */
public class PilaArregloTest {
    
    public PilaArregloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class PilaArreglo.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        
        String nuevoElemento = "CadenaPrueba";
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = true;
        
        boolean result = instance.push(nuevoElemento);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class PilaArreglo.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        
        PilaArreglo instance = new PilaArreglo();
        
        Object expResult = null;
        Object result = instance.pop();
        
        assertEquals(expResult, result);
        
        instance.push("Cabeza");
        
        result = instance.pop();
        
        assertEquals("Cabeza", result);
    }

    /**
     * Test of peek method, of class PilaArreglo.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PilaArreglo instance = new PilaArreglo();
        Object expResult = null;
        
        Object result = instance.peek();
        
        assertEquals(expResult, result);
        
        expResult = "CadenaPrueba";
        
        instance.push(expResult);
        
        result = instance.peek();
        
        assertEquals(expResult, result);
        
        result = instance.pop();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class PilaArreglo.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PilaArreglo instance = new PilaArreglo(100);
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        
        for(int i = 0; i < 50; ++i)
            instance.push(Integer.toString(i));
        
        assertEquals(instance.size(), 50);
    }

    /**
     * Test of isEmpty method, of class PilaArreglo.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class PilaArreglo.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object o = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class PilaArreglo.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        PilaArreglo instance = new PilaArreglo();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        
        int cuantos = 100, c = 99;
        for (int i = 0; i < cuantos; ++i)
            instance.push(Integer.toString(i));

        for (Object s : instance){
            if(!Integer.toString(c).equals(s)){
                fail("EL iterador no pasa por el elemento " + c);
            }
            if(c>0)
                --c;
        }
        
        assertEquals(0, c);
    }

    /**
     * Test of toArray method, of class PilaArreglo.
     */
//    @Test
//    public void testToArray_0args() {
//        System.out.println("toArray");
//        PilaArreglo instance = new PilaArreglo();
//        Object[] expResult = null;
//        Object[] result = instance.toArray();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    /**
     * Test of remove method, of class PilaArreglo.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object o = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class PilaArreglo.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection c = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class PilaArreglo.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        Collection c = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testAdd(){
        System.out.println("add");
        Object e = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        
        fail("The test case is a prototype");
    }

//    /**
//     * Test of removeAll method, of class PilaArreglo.
//     */
//    @Test
//    public void testRemoveAll() {
//        System.out.println("removeAll");
//        Collection c = null;
//        PilaArreglo instance = new PilaArreglo();
//        boolean expResult = false;
//        boolean result = instance.removeAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of retainAll method, of class PilaArreglo.
//     */
//    @Test
//    public void testRetainAll() {
//        System.out.println("retainAll");
//        Collection c = null;
//        PilaArreglo instance = new PilaArreglo();
//        boolean expResult = false;
//        boolean result = instance.retainAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of clear method, of class PilaArreglo.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        PilaArreglo instance = new PilaArreglo();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
