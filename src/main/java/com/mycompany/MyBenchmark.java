/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.mycompany;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3, jvmArgsAppend = {"-server", "-disablesystemassertions"})
public class MyBenchmark {

    int x = 347;
    int y = 189;

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public void void_baseline() {
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public int zero_baseline() {
        return 0;
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public int one_baseline() {
        return 1;
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public int constant() {
        return 199;
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public int sum() {
        return x + y;
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public int folding_sum() {
        return 177 + 367;
    }

    @Benchmark
    @Warmup(iterations = 5, time = 4, timeUnit = TimeUnit.SECONDS)
    public void deadcode_sum() {
         int sum = x + y;
    }


}
