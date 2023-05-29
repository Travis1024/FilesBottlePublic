package com.travis.filesbottle.document.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.travis.filesbottle.common.utils.R;
import com.travis.filesbottle.document.entity.FileDocument;
import com.baomidou.mybatisplus.extension.service.IService;
import org.elasticsearch.search.SearchHit;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author travis-wei
 * @since 2023-04-11
 */
public interface DocumentService extends IService<FileDocument> {

    List<FileDocument> selectAllListByPage(Page<FileDocument> page, QueryWrapper<FileDocument> queryWrapper);

    R<?> uploadFile(String userId, String userName, String fileMd5, String property, String description, MultipartFile file);

    FileDocument searchFileByMd5(String md5, String teamId);

    /**
     * 为controller提供在线预览的服务、返回源文件流 or 预览文件流 or URL
     * @param sourceId
     * @return
     */
    R<?> getPreviewDocStream(String sourceId);

    /**
     * 为controller提供源文件下载的服务
     * @param sourceId
     * @return
     */
    R<?> getSourceDocStream(String sourceId);

    R<?> deleteDocumentById(String sourceId);

    List<SearchHit> esDocumentByKeyword(String keyword, String userId) throws IOException;

}
