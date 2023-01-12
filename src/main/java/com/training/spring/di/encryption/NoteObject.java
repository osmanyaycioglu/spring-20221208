package com.training.spring.di.encryption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "note")
public class NoteObject {
    private String desc1;
    private String desc2;
    private String desc3;
    private Integer intVal;
    private List<String> strings;
    private NoteType noteType;
    private List<NoteType> noteTypes;
    private Map<String,NoteType> noteTypeMap;


    public String getDesc1() {
        return JasyptSec.defaultEnc.decrypt(desc1) ;
    }

    public String getDesc2() {
        return JasyptSec.defaultEnc.decrypt(desc2) ;
    }

    public String getDesc3() {
        return JasyptSec.defaultEnc.decrypt(desc3) ;
    }

    public void setDesc1(String desc1Param) {
        desc1 = desc1Param;
    }

    public void setDesc2(String desc2Param) {
        desc2 = desc2Param;
    }

    public void setDesc3(String desc3Param) {
        desc3 = desc3Param;
    }

    public Integer getIntVal() {
        return intVal;
    }

    public void setIntVal(Integer intValParam) {
        intVal = intValParam;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> stringsParam) {
        strings = stringsParam;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteTypeParam) {
        noteType = noteTypeParam;
    }

    public Map<String, NoteType> getNoteTypeMap() {
        return noteTypeMap;
    }

    public void setNoteTypeMap(Map<String, NoteType> noteTypeMapParam) {
        noteTypeMap = noteTypeMapParam;
    }

    public List<NoteType> getNoteTypes() {
        return noteTypes;
    }

    public void setNoteTypes(List<NoteType> noteTypesParam) {
        noteTypes = noteTypesParam;
    }

    @Override
    public String toString() {
        return "NoteObject{" +
               "desc1='" + desc1 + '\'' +
               ", desc2='" + desc2 + '\'' +
               ", desc3='" + desc3 + '\'' +
               ", intVal=" + intVal +
               ", strings=" + strings +
               ", noteType=" + noteType +
               ", noteTypes=" + noteTypes +
               ", noteTypeMap=" + noteTypeMap +
               '}';
    }
}
