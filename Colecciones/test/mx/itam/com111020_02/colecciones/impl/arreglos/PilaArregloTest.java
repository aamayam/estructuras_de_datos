/*
 * The MIT License
 *
 * Copyright 2020 alan-.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mx.itam.com111020_02.colecciones.impl.arreglos;

import java.util.Collection;
import java.util.Iterator;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alan-
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
        String nuevoE = "CadenaPrueba";
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = true;
        boolean result = instance.push(nuevoE);
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
        
        instance.push("head");
        result = instance.pop();
        assertEquals("head", result);
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
        
        expResult = "cadena";
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
        
        for(int i=0;i<50;i++){
            instance.push(Integer.toString(i));
        }
        
        assertEquals(instance.size(),50);
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
        
        int cuantos  = 100, c = 99;
        for(int i = 0; i < cuantos; i++)
            instance.push(Integer.toString(i));
        
        for (Object s: instance){
            if(!Integer.toString(c).equals(s)){
                fail("El iterador no pasa por el elemento" + c);
            }
            if(c>0)
                --c;
        }            
        
        assertEquals(0,c);
    }

    /**
     * Test of toArray method, of class PilaArreglo.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        PilaArreglo instance = new PilaArreglo();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class PilaArreglo.
     */
//    @Test
//    public void testToArray_GenericType() {
//        System.out.println("toArray");
//        Object[] arg0 = null;
//        PilaArreglo instance = new PilaArreglo();
//        Object[] expResult = null;
//        Object[] result = instance.toArray(arg0);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of add method, of class PilaArreglo.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object e = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PilaArreglo.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object arg0 = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.remove(arg0);
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

    /**
     * Test of removeAll method, of class PilaArreglo.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection arg0 = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.removeAll(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class PilaArreglo.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection arg0 = null;
        PilaArreglo instance = new PilaArreglo();
        boolean expResult = false;
        boolean result = instance.retainAll(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
