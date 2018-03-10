package com.compu;

import java.io.IOException;

public class TestComputerResource {


    public static void main(String[] args) throws IOException {

/*        Computer com1 =new Computer();

        com1.play();
        com1.close();//现在想改用closable的try--with-resource方式*/

       Computer com1 = new Computer();

       try(ComputerAdapter ca  = new ComputerAdapter(com1);){
           ca.close();
       }

    }

}

