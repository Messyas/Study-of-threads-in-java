package app2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> lista1 = Arrays.asList(
            "Stairway to Heaven - Led Zeppelin",
            "Hotel California - Eagles",
            "Bohemian Rhapsody - Queen",
            "Sweet Child o' Mine - Guns N' Roses",
            "Smells Like Teen Spirit - Nirvana"
        );

        List<String> lista2 = Arrays.asList(
            "Comfortably Numb - Pink Floyd",
            "Imagine - John Lennon",
            "Paranoid - Black Sabbath",
            "Creep - Radiohead",
            "Yesterday - The Beatles"
        );

        TransmissorReceptorThread2 receptor1 = new TransmissorReceptorThread2(new ArrayList<>(lista1));
        receptor1.start();

        TransmissorReceptorThread2 transmissor1 = new TransmissorReceptorThread2(new ArrayList<>(lista1));
        transmissor1.start();

        TransmissorReceptorThread2 receptor2 = new TransmissorReceptorThread2(new ArrayList<>(lista2));
        receptor2.start();

        TransmissorReceptorThread2 transmissor2 = new TransmissorReceptorThread2(new ArrayList<>(lista2));
        transmissor2.start();
    }
}