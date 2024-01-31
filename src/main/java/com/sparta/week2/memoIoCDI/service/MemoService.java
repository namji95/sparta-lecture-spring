//package com.sparta.week2.memoIoCDI.service;
//
//import com.sparta.week2.memoIoCDI.dto.MemoRequestDto;
//import com.sparta.week2.memoIoCDI.dto.MemoResponseDto;
//import com.sparta.week2.memoIoCDI.entity.Memo;
//import com.sparta.week2.memoIoCDI.repository.MemoRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//// @RequiredArgsConstructor 어노테이션으로 생성자 주입을 할 수 있습니다.
//@Service
//public class MemoService {
//// MemoController -> MemoService -> MemoRepository 흐름
//
//    /*
//    메소드 주입 방법
//    private MemoRepository memoRepository;
//
//    @Autowired // 이 어노테이션을 붙여줘야 Bean으로 등록됩니다.
//    public void setDi(MemoRepository memoRepository) {
//        this.memoRepository = memoRepository;
//    }
//     */
//
//    /*
//     주입받는 생성자에 원래 AutoWired 어노테이션을 붙여줘야 했지만
//     Spring에서 생성자 1개일 경우 생략해도 되게 업데이트 했습니다.
//     */
//
//    /*
//    private final MemoRepository memoRepository;
//    public MemoService(MemoRepository memoRepository) {
//        this.memoRepository = memoRepository;
//    }
//     */
//
////    private final MemoRepository memoRepository;
//
////    public MemoService (ApplicationContext context) {
////        // 1. Bean 이름으로 가져오기
////        // MemoRepository memoRepository = (MemoRepository) context.getBean("memoRepository");
////        // MemoRepository 객체에 ApplcationContext를 이용하여 Bean으로 등록하겠다라는 의미입니다. MemoRepository로 캐스팅을 해줘야 합니다.
////
////        // 2. 클래스 형식으로 가져오기
////        // MemoRepository memoRepository = context.getBean(MemoRepository.class);
////        // this.memoRepository = memoRepository;
////    }
//
//    private final MemoRepository memoRepository;
//    public MemoService(MemoRepository memoRepository) {
//        this.memoRepository = memoRepository;
//    }
//
//    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
//        // RequestDto -> Entity
//        Memo memo = new Memo(requestDto);
//
//        // DB 저장
//        Memo saveMemo = memoRepository.save(memo);
//
//        // Entity -> ResponseDto
//        MemoResponseDto memoResponseDto = new MemoResponseDto(saveMemo);
//
//        return memoResponseDto;
//    }
//
//    public List<MemoResponseDto> getMemos() {
//        // DB 조회
//        return memoRepository.findAll();
//    }
//
//    public Long updateMemo(Long id, MemoRequestDto requestDto) {
//        // 해당 메모가 DB에 존재하는지 확인
//        Memo memo = memoRepository.findById(id);
//        if (memo != null) {
//            // memo 내용 수정
//            memoRepository.update(id, requestDto);
//
//            return id;
//        } else {
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
//    }
//
//    public Long deleteMemo(Long id) {
//        // 해당 메모가 DB에 존재하는지 확인
//        Memo memo = memoRepository.findById(id);
//        if (memo != null) {
//            // memo 삭제
//            memoRepository.delete(id);
//
//            return id;
//        } else {
//            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
//        }
//    }
//}