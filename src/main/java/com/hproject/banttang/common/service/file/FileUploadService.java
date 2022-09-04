package com.hproject.banttang.common.service.file;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hproject.banttang.common.entity.file.S3Image;
import com.hproject.banttang.common.infra.file.repository.FileRepository;
import com.hproject.banttang.common.service.file.exception.FileConvertException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Component
public class FileUploadService {

//    private final AmazonS3Client amazonS3Client;
//    private final FileRepository fileRepository;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    public String upload(MultipartFile multipartFile, String directoryName) {
//        File uploadFile = convert(multipartFile)
//                .orElseThrow(FileConvertException::new);
//
//        String fileName = directoryName + "/" + UUID.randomUUID() + uploadFile.getName();
//        String uploadImageUrl = putS3(uploadFile, fileName);
//        removeNewFile(uploadFile);
//
//        return uploadImageUrl;
//    }
//
//    public void deleteImages(List<String> deleteImages) {
//        if (deleteImages != null) {
//            List<S3Image> imageFiles = fileRepository.findAllByImageUrl(deleteImages);
//            imageFiles.forEach(
//                    s3Image -> {
//                        amazonS3Client.deleteObject(new DeleteObjectRequest(bucket, s3Image.getFileName()));
//                        s3Image.updateDeleteAd();
//                    }
//            );
//        }
//    }
//
//    private String putS3(File uploadFile, String fileName) {
//        log.info("S3 file upload fileName ================ {}", fileName);
//        amazonS3Client.putObject(
//                new PutObjectRequest(bucket, fileName, uploadFile)
//                        .withCannedAcl(CannedAccessControlList.PublicRead)
//        );
//
//        String imageUrl = amazonS3Client.getUrl(bucket, fileName).toString();
//        fileRepository.save(
//                S3Image.builder()
//                        .imageUrl(imageUrl)
//                        .fileName(fileName)
//                        .build()
//        );
//        return imageUrl;
//    }
//
//    private void removeNewFile(File targetFile) {
//        if (targetFile.delete()) {
//            log.info("File delete success");
//        }
//        log.info("File delete fail");
//    }
//
//    private Optional<File> convert(MultipartFile file) {
//        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
//        try {
//            if (convertFile.createNewFile()) {
//                try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile)) {
//                    fileOutputStream.write(file.getBytes());
//                }
//                return Optional.of(convertFile);
//            }
//        } catch (IOException e) {
//            throw new FileConvertException(e);
//        }
//        return Optional.empty();
//    }
//
//    public List<String> uploadImages(List<MultipartFile> multipartFiles) {
//        return multipartFiles.stream()
//                .map(image -> upload(image, "image"))
//                .collect(toList());
//    }
}