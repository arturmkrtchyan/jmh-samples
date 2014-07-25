package com.mycompany;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3, jvmArgsAppend = {"-server", "-disablesystemassertions"})
public class Iban4jBenchmark {

    @Benchmark
    @Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
    public void void_baseline() {
    }

    @Benchmark
    @Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
    public int constant_baseline() {
        return 1;
    }

    @Benchmark
    @Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
    public Iban iban_creation() {
        return new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();
    }

    @Benchmark
    @Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
    public Iban iban_valueof() {
        return Iban.valueOf("DE89370400440532013000");
    }

}
