package com.javaquarium.beans.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 17/02/2017.
 */

@Component
@Scope("session")
public class AquariumVO {

    private List<PoissonVO> lstPoissonsAquarium = new ArrayList<>();

    public List<PoissonVO> getLstPoissonsAquarium() {
        return lstPoissonsAquarium;
    }

    public void setLstPoissonsAquarium(List<PoissonVO> lstPoissonsAquarium) {
        this.lstPoissonsAquarium = lstPoissonsAquarium;
    }
}
