/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya 191165 (aamayama@itam.mx) .
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class ColaArregloCircularTest {
    
    public ColaArregloCircularTest() {
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
     * Test of add method, of class ColaArregloCircular.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object arg0 = null;
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.add(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ColaArregloCircular.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object arg0 = null;
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.remove(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class ColaArregloCircular.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection arg0 = null;
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.removeAll(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class ColaArregloCircular.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection arg0 = null;
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.retainAll(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enqueue method, of class ColaArregloCircular.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object elemento = null;
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.enqueue(elemento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class ColaArregloCircular.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        ColaArregloCircular instance = new ColaArregloCircular();
        boolean expResult = false;
        boolean result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primero method, of class ColaArregloCircular.
     */
    @Test
    public void testPrimero() {
        System.out.println("primero");
        ColaArregloCircular instance = new ColaArregloCircular();
        Object expResult = null;
        Object result = instance.primero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ultimo method, of class ColaArregloCircular.
     */
    @Test
    public void testUltimo() {
        System.out.println("ultimo");
        ColaArregloCircular instance = new ColaArregloCircular();
        Object expResult = null;
        Object result = instance.ultimo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
