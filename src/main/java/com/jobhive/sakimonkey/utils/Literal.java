package com.jobhive.sakimonkey.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
/* Copyright 2005-2006 Tim Fennell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * https://github.com/StripesFramework/stripes
 */
public class Literal {

    /** Returns an array containing all the elements supplied. */
    @SafeVarargs
    public static <T> T[] array(T... elements) {
        return elements;
    }

    /** Returns a new List instance containing the supplied elements. */
    @SafeVarargs
    public static <T> List<T> list(T... elements) {
        if(elements == null) return null;
        List<T> list = new ArrayList<T>();
        Collections.addAll(list, elements);
        return list;
    }

    /** Returns a new Set instance containing the supplied elements. */
    @SafeVarargs
    public static <T> Set<T> set(T... elements) {
        if(elements == null) return null;
        Set<T> set = new HashSet<T>();
        Collections.addAll(set, elements);
        return set;
    }
    
}