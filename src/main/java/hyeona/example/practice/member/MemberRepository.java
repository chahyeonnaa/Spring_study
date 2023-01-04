package hyeona.example.practice.member;

public interface MemberRepository {

    // 저장
    void save(Member member);

    // 찾기
    Member findById(Long memberId);
}
