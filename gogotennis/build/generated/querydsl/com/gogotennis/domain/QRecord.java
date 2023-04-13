package com.gogotennis.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecord is a Querydsl query type for Record
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecord extends EntityPathBase<Record> {

    private static final long serialVersionUID = 326655641L;

    public static final QRecord record = new QRecord("record");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> lose = createNumber("lose", Integer.class);

    public final NumberPath<Integer> penalty = createNumber("penalty", Integer.class);

    public final NumberPath<Integer> points = createNumber("points", Integer.class);

    public final NumberPath<Double> rate = createNumber("rate", Double.class);

    public final NumberPath<Integer> win = createNumber("win", Integer.class);

    public QRecord(String variable) {
        super(Record.class, forVariable(variable));
    }

    public QRecord(Path<? extends Record> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecord(PathMetadata metadata) {
        super(Record.class, metadata);
    }

}

