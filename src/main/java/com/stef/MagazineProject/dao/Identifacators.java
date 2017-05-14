package com.stef.MagazineProject.dao;

import java.io.Serializable;

public interface Identifacators<PK extends Serializable> {
    PK getId();
}
