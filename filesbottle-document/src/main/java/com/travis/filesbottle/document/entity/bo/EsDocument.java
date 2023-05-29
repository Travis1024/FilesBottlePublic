package com.travis.filesbottle.document.entity.bo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @ClassName EsDocument
 * @Description ElasticSearch存储的信息实体
 * @Author travis-wei
 * @Version v1.0
 * @Data 2023/4/13
 */
@Data
@Document(indexName = "document")
public class EsDocument implements Serializable {
    @Id
    @Field(type = FieldType.Text)
    private String gridFsId;
    @Field(type = FieldType.Text)
    private String previewId;
    @Field(type = FieldType.Text, analyzer = "ik-max-word")
    private String fileName;
    @Field(type = FieldType.Text, analyzer = "ik-max-word")
    private String fileDescription;
    @Field(type = FieldType.Text, analyzer = "ik-max-word")
    private String fileText;

    public static final String GRID_FS_ID = "gridFsId";
    public static final String PREVIEW_ID = "previewId";
    public static final String FILE_NAME = "fileName";
    public static final String FILE_DESCRIPTION = "fileDescription";
    public static final String FILE_TEXT = "fileText";

}
