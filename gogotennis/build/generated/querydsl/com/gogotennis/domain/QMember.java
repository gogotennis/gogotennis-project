package com.gogotennis.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 183794914L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final StringPath accessToken = createString("accessToken");

    public final StringPath birthday = createString("birthday");

    public final StringPath email = createString("email");

    public final EnumPath<com.gogotennis.web.Gender> gender = createEnum("gender", com.gogotennis.web.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath introduction = createString("introduction");

    public final StringPath loginId = createString("loginId");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final EnumPath<com.gogotennis.web.Provider> provider = createEnum("provider", com.gogotennis.web.Provider.class);

    public final QRecord record;

    public final EnumPath<com.gogotennis.web.Role> role = createEnum("role", com.gogotennis.web.Role.class);

    public final EnumPath<com.gogotennis.web.Tier> tier = createEnum("tier", com.gogotennis.web.Tier.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.record = inits.isInitialized("record") ? new QRecord(forProperty("record")) : null;
    }

}

