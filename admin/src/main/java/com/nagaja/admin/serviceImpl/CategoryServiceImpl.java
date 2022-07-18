package com.nagaja.admin.serviceImpl;

import com.nagaja.admin.dto.BoardCategoryDto;
import com.nagaja.admin.dto.CategoryUpdateDto;
import com.nagaja.admin.entity.BoardCategory;
import com.nagaja.admin.entity.Pagination;
import com.nagaja.admin.mapper.CategoryMapper;
import com.nagaja.admin.service.CategoryService;
import com.nagaja.admin.util.AWSUploader;
import com.nagaja.admin.util.MyUtils;
import com.nagaja.admin.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final AWSUploader AWSUploader;

    //TODO 카테고리 리스트 설렉트
    @Override
    public BoardCategoryDto selectCategory(BoardCategoryDto dto)
    {
        int count = categoryMapper.categoryCount();

        Pagination pagination = MyUtils.Paging(count, dto.getPageNum(), dto.getLimit());

        List<BoardCategory> boardCategoryList = categoryMapper.categoryList(pagination.getOffset(), pagination.getLimit());

        return BoardCategoryDto.builder().boardCategoryList(boardCategoryList).pagination(pagination).build();
    }

    //TODO 하위 카테고리 리스트 설렉트
    @Override
    public BoardCategoryDto selectLowerRankCategory(BoardCategoryDto dto)
    {
        int count = categoryMapper.lowerRankCategoryCount(dto.getBoardCategoryId());

        Pagination pagination = MyUtils.Paging(count, dto.getPageNum(), dto.getLimit());

        List<BoardCategory> boardCategoryList = categoryMapper.lowerRankCategoryList(dto.getBoardCategoryId(), pagination.getOffset(), pagination.getLimit());

        return BoardCategoryDto.builder().boardCategoryList(boardCategoryList).pagination(pagination).build();
    }

    //TODO 카테고리 디테일
    @Override
    public BoardCategory detailCategory(int boardCategoryId)
    {
        return categoryMapper.detailCategory(boardCategoryId);
    }

    //TODO 카테고리 인서트
    public int insertCategory(BoardCategory boardCategoryId)
    {
        int result = categoryMapper.insertCategory(boardCategoryId);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 카테고리 업데이트
    @Override
    public int updateCategory(CategoryUpdateDto dto)
    {
        System.out.println(dto.getFile());
        if (dto.getFile() != null && !dto.getFile().isEmpty())
        {

            String aws_name = AWSUploader.changeFileName(dto.getFile());
            boolean uploadAWS = AWSUploader.uploadToWithNameAwsS3("nagaja/category", dto.getFile(), aws_name);

            if(uploadAWS)
            {
                if(dto.getBoardCategoryImageName() != null)
                {
                    String[] imageName = dto.getBoardCategoryImageName().split("/");
                    String path = imageName[0] + "/" + imageName[1];
                    boolean deleteAWS = AWSUploader.deleteFileInAwsByKey(path, imageName[2]);
                }

                String file_name = "nagaja/category/" + aws_name;

                dto.setBoardCategoryImageName(file_name);
                dto.setBoardCategoryImageOrigin(dto.getFile().getOriginalFilename());
            }

        }
        int result = categoryMapper.updateCategory(dto);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }

    //TODO 서브카테고리 삭제
    @Override
    public int deleteCategory(BoardCategory dto, int parentPk)
    {
        int result = categoryMapper.deleteCategory(dto);

        categoryMapper.updateFirstOfAllCategory(dto, parentPk);

        if (result == 0)
        {
            return Status.ZERO;
        }
        return Status.FIRST;
    }
}
