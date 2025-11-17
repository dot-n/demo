package com.demo;

import com.demo.model.ModeA;
import org.junit.jupiter.api.Test;
import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.JarFileArchive;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void archiveTest() throws Exception {

        File jarRoot = new File("D:\\code\\test\\demo\\target\\demo-0.0.1-SNAPSHOT.jar");
        JarFileArchive jarFileArchive = new JarFileArchive(jarRoot);
        Manifest manifest = jarFileArchive.getManifest();


        JarLauncher.main(new String[]{"--spring.profiles.active=dev"});
    }

    @Test
    void urlTest() throws Exception {
        List<URL> urls = new ArrayList<>();
        urls.add(new URL("file:D:\\code\\test\\demo\\target\\demo-0.0.1-SNAPSHOT.jar"));
        urls.add(new URL("file:D:\\code\\test\\demo\\target\\classes"));
        urls.add(new URL("file:D:\\code\\test\\demo\\target\\lib\\spring-boot-starter-tomcat-2.5.6.jar"));

        URL[] urls1 = urls.toArray(new URL[0]);
        System.out.println(Arrays.toString(urls1));
    }

    @Test
    void intTest() {

        int a1 = 10;
        double a2 = 10.0;
        long a3 = 10L;
        float a4 = 10.0f;
        System.out.println("int==double " + (a1 == a2));
        System.out.println("int==long " + (a1 == a3));
        System.out.println("int==float " + (a1 == a4));
    }

    @Test
    void reflectTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.demo.model.ModeA");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        ModeA modeA = (ModeA) constructor.newInstance();
        modeA.setName("dot");
        System.out.println(modeA);

    }

    @Test
    void test1() {
        byte a = 127;
        byte b = 127;
        b+=a ;
    }
    @Test
    void test2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addLast(2);
        list.addFirst(3);
    }

    @Test
    void testInsertionSort() {
        //插入排序
        int[] arr = {5, 4, 3, 2, 1};
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int position=i-1;
            while (position >= 0 ){
                if(arr[position]> temp){
                    arr[position+1] = arr[position];
                } else{
                    break;
                }
                position--;
            }
            arr[position+1] = temp;
        }
    }

    @Test
    void testIntersection() {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {5, 4, 3, 2, 1};
        Set< Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set< Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Set<Integer> result = set1.parallelStream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(result);
    }


}
