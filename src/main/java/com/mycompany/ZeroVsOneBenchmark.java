package com.mycompany;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3, jvmArgsAppend = {"-server", "-disablesystemassertions"})
public class ZeroVsOneBenchmark {

    @Benchmark
    @Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 30, time = 10, timeUnit = TimeUnit.SECONDS)
    public int zero() {
        return 0;
    }

    @Benchmark
    @Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 30, time = 15, timeUnit = TimeUnit.SECONDS)
    public int one() {
        return 1;
    }

    @Benchmark
    @Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 30, time = 15, timeUnit = TimeUnit.SECONDS)
    public int two() {
        return 2;
    }

}
