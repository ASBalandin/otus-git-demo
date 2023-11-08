package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.List;

public class StringTree implements SearchTree<StringTree> {
    String name;
    List<StringTree> children = new ArrayList<>();

    public StringTree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public StringTree find(StringTree element) {
        return null;
    }

    @Override
    public List getSortedList() {
        return null;
    }
    public List<StringTree> getChildren() {
        return children;
    }

    public void setChildren(List<StringTree> children) {
        this.children = children;
    }

}
