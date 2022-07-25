package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.AnnouncementsDto;
import com.nagaja.admin.dto.AnnouncementsUpdDto;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.BoardImage;
import com.nagaja.admin.mapper.AnnouncementsMapper;
import com.nagaja.admin.service.AnnouncementsService;
import com.nagaja.admin.util.AWSUploader;
import com.nagaja.admin.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementsServiceImpl implements AnnouncementsService {

    private final AnnouncementsMapper announcementsMapper;
    private final AWSUploader AWSUploader;

    //TODO 자식 카테고리 설렉트
    public List<BoardCategory> selectChildBoard()
    {
        return announcementsMapper.selectChildBoard();
    }

    //TODO 현지뉴스 등록
    public int insertAnnouncements(AnnouncementsDto announcementsDto)
    {
        //TODO 공백 OR 빈값
        if (announcementsDto.getBoardTitle().trim().equals("") || announcementsDto.getBoardContent().trim().equals(""))
        {
            return Status.SECOND;
        }

        int result = announcementsMapper.insertAnnouncements(announcementsDto);

        if (announcementsDto.getFiles() != null && !announcementsDto.getFiles().get(0).isEmpty())
        {
            for (MultipartFile data : announcementsDto.getFiles())
            {
                String aws_name = AWSUploader.changeFileName(data);
                boolean uploadAWS = AWSUploader.uploadToWithNameAwsS3("nagaja/announcements", data, aws_name);

                if(uploadAWS)
                {

                    String file_name = "nagaja/announcements/" + aws_name;

                    BoardImage boardImage = new BoardImage();
                    boardImage.setBoardId(announcementsDto.getBoardId());
                    boardImage.setBoardImageName(file_name);
                    boardImage.setBoardImageOrigin(data.getOriginalFilename());
                    announcementsMapper.insertAnnouncementsImage(boardImage);
                }
            }
        }

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 공지사항 업데이트
    public int updateAnnouncements(AnnouncementsUpdDto announcementsUpdDto)
    {
        //TODO 공백 OR 빈값
        if (announcementsUpdDto.getBoardTitle().trim().equals("") || announcementsUpdDto.getBoardContent().trim().equals(""))
        {
            return Status.SECOND;
        }

        int result = announcementsMapper.updateAnnouncements(announcementsUpdDto);

        //TODO 공지사항 이미지 삭제
        if (announcementsUpdDto.getBoardImageId() != null && announcementsUpdDto.getBoardImageId().size() != 0)
        {
            // 인테리어 회사 이미지 삭제
            for (Integer id : announcementsUpdDto.getBoardImageId())
            {
                BoardImage bi = announcementsMapper.selectFile(id);
                String[] imageName = bi.getBoardImageName().split("/");
                String path = imageName[0] + "/" + imageName[1];
                AWSUploader.deleteFileInAwsByKey(path, imageName[2]);
                announcementsMapper.deleteFile(id);
            }
        }

        //TODO 공지사항 추가 이미지 등록
        if (announcementsUpdDto.getFiles() != null && !announcementsUpdDto.getFiles().get(0).isEmpty())
        {
            for (MultipartFile data : announcementsUpdDto.getFiles())
            {
                String aws_name = AWSUploader.changeFileName(data);
                boolean uploadAWS = AWSUploader.uploadToWithNameAwsS3("nagaja/announcements", data, aws_name);

                if(uploadAWS)
                {

                    String file_name = "nagaja/announcements/" + aws_name;

                    BoardImage boardImage = new BoardImage();
                    boardImage.setBoardId(announcementsUpdDto.getBoardId());
                    boardImage.setBoardImageName(file_name);
                    boardImage.setBoardImageOrigin(data.getOriginalFilename());
                    announcementsMapper.insertAnnouncementsImage(boardImage);
                }
            }
        }

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 공지사항 상단 업데이트
    @Override
    public int changeAnnouncements(int boardId)
    {
        int result = announcementsMapper.changeAnnouncements(boardId);
        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 공지사항 삭제
    @Override
    public int deleteAnnouncements(int boardId)
    {
        int count = announcementsMapper.noticeAnnouncementsCount(boardId);

        if (count != 0)
        {
            return 2;
        }
        List<BoardImage> list = announcementsMapper.selectFileList(boardId);

        //TODO 공지사항 이미지 삭제
        if (list != null && list.size() != 0)
        {
            // 인테리어 회사 이미지 삭제
            for (BoardImage id : list)
            {
                BoardImage bi = announcementsMapper.selectFile(id.getBoardImageId());
                String[] imageName = bi.getBoardImageName().split("/");
                String path = imageName[0] + "/" + imageName[1];
                AWSUploader.deleteFileInAwsByKey(path, imageName[2]);
                announcementsMapper.deleteFile(id.getBoardImageId());
            }
        }

        int result = announcementsMapper.deleteAnnouncements(boardId);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }
}
