package sql;
/*
 * 
 * 2016_12_08
 * 
 * 오라클 기본 포트 : 1521
 * NOT NULL : 값이 항상 들어가야 한다.
 * 
 * 제1정규화 : 데이터에 공백이 들어가지 않도록.
 * 제2정규화 : 중복된 데이터가 만들어지지 않도록.
 * 
 * select * from tab; -> 해당 데이터베이스의 모든 테이블 조회.
 * desc 테이블명 -> 테이블의 구조를 조회.
 * 
 * 오라클의 데이터 형
 *  1. NUMBER 데이터 형 
 *    NUMBER(precision, scale) -> scale : 소수점 자리 수
 *  
 *  2. VARCHAR2 데이터 형
 *    가변 문자열 데이터 형
 *     - 영문자는 한글자에 한공간을 차지
 *     - 한글자는 한글자에 세공간을 차지
 *    
 *  3. DATE 데이터 형
 *    날짜를 표현하는 데이터 형
 * 
 * SELECT 문
 *  SELECT [DISTINCT] 컬럼, ... FROM 테이블 명;
 *   
 *   *NULL 도 데이터 이다.
 *    1. 0(zero)도 아니고
 *    2. 빈 공간도 아니다
 *    3. 미확정(해당 사항 없음), 알 수 없는(unknown) 값을 의미한다.
 *    4. 어떤 값인지 알 수 없지만 어떤 값이 존재하고 있다.
 *    5. ? 혹은 무한대 의 의미 이므로
 *    6. 연산, 할당, 비교가 불가능 하다.
 *    
 * 별칭
 *  [1] 대문자 소문자를 구분하지만 결과는 대소문자 구분하지 않고 출력.
 *  SQL > SELECT ename, sal*12+comm Annsal FROM emp;
 *  
 *  [2] ""사이에는 공백문자, _, # 사용 가능하며 대소문자가 구분되어 출력.
 *  SQL > SELECT ename, sal*12+comm "A n n s a l" FROM emp;
 *  
 *  [3] 한글 사용이 가능하다.
 *  SQL > SELECT ename, sal*12+comm "연봉" FROM emp;
 *  
 *  [4] AS를 사용하여 별칭을 부여하는 경우.
 *  SQL > SELECT ename, sal*12+comm AS Annsal FROM emp;
 *  
 *    * "" -> 별칭에만 유일하게 사용.
 *  	'' -> 문자열 표현하는데 사용.
 *  	
 * Concatenation ( || ) 연산자의 정의와 사용
 *  컬럼과 컬럼을 연결함.
 *  SQL > SELECT ename, 'is a', job FROM emp;
 *  SQL > SELECT enmae || 'is a' || job FROM emp;
 *  
 * DISTINCT 키워드
 *  중복되는 데이터를 한번만 보여줌.
 *  SQL > SELECT DISTINCT deptno FROM emp;
 *  
 * WHERE 절
 *  특정 데이터를 추출하기 위한 조건을 명시
 *  SQL > SELECT columns FROM table_name WHERE conditions;
 *  
 *  ex) 부서번호가 10번인 사원에 관한 정보
 *   SQL > SELECT * FROM emp WHERE deptno = 10;
 *  ex) 급여가 2000이상 되는 사람의 사원번호, 사원이름, 급여를 출력
 *   SQL > SELECT * FROM emp WHERE sal >= 2000;
 *  ex) 이름이 FORD 인 사원의 사원번호, 사원이름을 출력
 *   SQL > SELECT empno, ename FROM emp WHERE ename = 'FORD';
 *     * 주의할 점
 *      -> 단일 따옴표 안에 문자열 데이터는 대소문자를 구분하므로 소문자로
 *         사원명을 기술하면 해당 데이터를 찾지 못합니다.
 * 
 * 논리 연산자
 *  AND - 두 가지 조건을 모두 만족해야만 검색할 수 있다.
 *   ex) 부서번호가 10이면서 직업이 CLERK 인 사원을 출력.
 *   SQL > SELECT * FROM emp WHERE deptno = 10 AND job = 'CLERK';
 *  OR - 두 가지 조건 중에서 한가지만 만족하더라도 검색할 수 있다.
 *   ex) 입사년도가 1982년 01월 01일 이후 이거나 직업이 MANAGER 인 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE hiredate >= '1982/01/01' OR job = 'MANAGER';
 *  NOT - 조건에 만족하지 못하는 것만 검색한다.
 *   ex) 부서번호가 10번이 아닌 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE NOT deptno = 10;
 *   SQL > SELECT * FROM emp WHERE deptno <> 10;
 *   ex) 급여가 2000 에서 3000 사이가 아닌 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;
 *   ex) 커미션이 300이거나 500이거나 1400이 아닌 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE comm NOT IN(300, 500, 1400);
 *   ex) 이름에 A가 들어가지 않는 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE ename NOT LIKE '%A%';
 *  IS - NULL 에 대한 판별
 *   ex) 커미션의 값이 null 인 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE comm IS NULL;
 *   ex) 커미션의 값이 null 이 아닌 사람을 출력.
 *   SQL > SELECT * FROM emp WHERE comm IS NOT NULL;
 * 
 * LIKE ( 문자 처리 연산자 )
 *  [형식] Column_name like 'pattern'
 *  ex) 사원 이름이 J로 시작하는 사람을 출력
 *  SQL > SELECT * FROM emp WHERE ename LIKE 'J%';
 *  ex) 사원 이름이 N으로 끝나는 사람을 출력
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%N';
 *  ex) 사원 이름에 A가 들어가는 사람을 출력
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%A%';
 *  ex) 사원 이름에 두번째 글짜가 A인 사람을 출력
 *  SQL > SELECT * FROM emp WHERE ename LIKE '_A%';
 *  
 *  
 * IN 연산자
 *  [형식] 컬럼 in(조회 값들..)
 *  ex) 커미션이 300 또는 500 또는 1400 인 사람을 출력
 *  SQL> SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;
 *  SQL> SELECT * FROM emp WHERE comm IN(300, 500, 1400);
 * 
 * BETWEEN AND 연산자
 * 
 *  [형식] 컬럼 BETWEEN 시작 AND 끝
 *  ex) 급여가 2000 에서 3000 사이인 사원을 출력
 *  SQL> SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;
 *  SQL> SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
 *  
 * ORDER BY ( 정렬하여 출력 )
 *  [형식] ORDER BY 컬렴명 [ASC | DESC]
 *  ex) 급여순으로 오름차순 정렬한 사원의 정보를 출력.
 *  SQL > SELECT * FROM emp ORDER BY sal;
 *  SQL > SELECT * FROM emp ORDER BY sal ASC;
 *  ex) 급여순으로 내림차순 정렬한 사원의 정보를 출력.
 *  SQL > SELECT * FROM emp ORDER BY sal DESC;
 *  ex) 부서번호로 오름차순 정렬하고 급여순으로 내림차순 정렬한 사원의 정보를 출력.
 *  SQL > SELECT * FROM emp ORDER BY deptno ASC, sal DESC;
 *  
 * DUAL 테이블
 *  - DAUL 테이블은 SYS 사용자가 소유하는 것으로 모든 사용자가 사용할 수 있다.
 *  - DAUL 테이블은 DUMMY라는 단 하나의 컬럼을로 구성되어 있습니다. 이 컬럼에는
 *    길이가 1인 문자 한 개를 저장할 수 있다.
 * 
 * ROUND (반올림) 함수
 *  [형식] ROUND(데이터, 반올림위치)
 *  ex) SELECT ROUND(45.293, 2) FROM dual; -> 45.29
 *  ex) SELECT ROUND(45.277, 2) FROM dual; -> 45.28
 *  ex) SELECT ROUND(45.293, 0) FROM dual; -> 45
 *  ex) SELECT ROUND(45.293, -1) FROM dual; -> 50
 *  
 * TRUNC (버림) 함수
 *  [형식] TRUNC(데이터, 버림위치)
 *  ex) SELECT TRUNC(45.196, 2) FROM dual; -> 45.19
 *  
 * MOD (나머지 구하는) 함수
 *  [형식] MOD(데이터, 나눌값)
 *  ex) 사원 테이블에서 사원번호, 사원이름, 급여를 100으로 나눈 나머지를 출력.
 *  SQL > SELECT empno, ename, sal, MOD(sal, 100) FROM emp;
 *  ex) 직원들 중에서 사번이 홀수인 사람만 검색
 *  SQL > SELECT * FROM emp WHERE MOD(empno, 2) = 1;
 *  
 * 문자 처리 함수
 *  UPPER : 대문자로 변환
 *   ex) SELECT UPPER('Welcome to Java') FROM dual; -> WELCOME TO JAVA
 *  LOWER : 소문자로 변환
 *   ex) SELECT LOWER('Welcome to Jave') FROM dual; -> welcome to java
 *  INITCAP : 이니셜만 대문자로 변환
 *   ex) SELECT INITCAP('welcome to java') FROM dual; -> Welcome To Java
 *  LENGTH : 문자열의 길이를 반환
 *   ex) SELECT LENGTH('Welcome to Java') FROM dual; -> 15
 *  INSTR : 특정문자가 출현하는 위치를 반환
 *   ex) 처음 'o' 출현하는 인덱스를 반환
 *   SQL > SELECT INSTR('Welcome to Java', 'o') FROM dual -> 5
 *   ex) 6번째 문자열부터 시작하여 처음 'o' 문자열이 출현하는 위치를 반환
 *   SQL > SELECT INSTR('Welcome to Java', 'o', 6, 1) FROM dual -> 10
 *   ex) 3번재 문자열부터 시작하여 두번째로 'o' 문자열이 출현하는 위치를 반환
 *   SQL > SELECT INSETR('Welcome to Java', 'o', 3, 2) FROM dual -> 10
 *   ex) 사원의 이름중에서 A 문자가 몇번째에 출몰하는지 가상컬럼으로 출력
 *   SQL > SELECT ename, INSTR(ename, 'A') FROM emp;
 *  SUBSTR : 문자의 일부분을 반환
 *   ex) 해당 문자열에서 4번째 문자 부터 4개의 문자열을 반환
 *   SQL > SELECT SUBSTR('Welcome to Java', 4, 4) -> come
 *   ex) 사원의 이름과 사원의 입사년도만을 출력
 *   SQL > SELECT SUBSTR(hiredate, 1, 4) FROM emp;
 *  LPAD : 오른쪽 정렬 후 왼쪽에 생긴 빈 공백에 특정 문자를 채운다.
 *   ex) 'javadori' 문자열의 왼쪽에 # 문자로 20개를 채워 출력
 *   SQL > SELECT LPAD('javadori', 20, '#') FROM dual;
 *  RPAD : 왼쪽 정렬 후 오른쪽에 생긴 빈 공백에 특정 문자를 채운다.
 *   ex) 'javadori' 문자열의 오른쪽에 # 문자로 20개를 채워 출력
 *   SQL > SELECT RPAD('javadori', 20, '#') FROM dual;
 *  LTRIM : 왼쪽에서 특정 문자를 삭제한다.
 *   ex) 'aaaaaajavadoriaaaaaaa' 에서 왼쪽에서 'a' 문자를 삭제하여 출력
 *   SQL > SELECT LTRIM('aaaaaajavadoriaaaaaaa', 'a') FROM dual;
 *   ex) '     javadori     ' 에서 왼쪽에서 공백을 제거하여 출력
 *   SQL > SELECT LTRIM('     javadori     ') FROM dual;    
 *  RTRIM : 오른쪽에서 특정 문자를 삭제한다.
 *   ex) 'aaaaaajavadoriaaaaaaa' 에서 오른쪽에서 'a' 문자를 삭제하여 출력
 *   SQL > SELECT RTRIM('aaaaaajavadoriaaaaaaa', 'a') FROM dual;
 *   ex) '     javadori     ' 에서 오른쪽에서 공백을 제거하여 출력
 *   SQL > SELECT RTRIM('     javadori     ') FROM dual; 
 *  TRIM : 양쪽에서 공백을 삭제한다.
 *   ex)  '     javadori     ' 에서 양쪽의 공백을 제거하여 출력
 *   SQL > SELECT TRIM('     javadori     ') FROM dual;
 * 
 *  실습 예제)
 *   ex) 이름의 세번째 자리가 R인 사원을 검색하시오.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, 3, 1) = 'R';
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'R', 3, 1) = 3;
 *   SQL > SELECT * FROM emp WHERE WHERE ename LIKE '__R%';
 *   
 *   ex) 이름의 끝 자리가 N으로 끝나는 사원을 검색하시오.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, LENGTH(ename), 1) = 'N';
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, -1, 1) = 'N';
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'N') = LENGTH(ename);
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'N', LENGTH(ename), 1) = LENGTH(ename);
 *   SQL > SELECT * FROM emp WHERE ename LIKE '%R';
 *   
 *   ex) 87년도에 입사한 직원을 검색하시오.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(hiredate, 3, 2) = '87';
 *   SQL > SELECT * FROM emp WHERE SUBSTR(hiredate, 3, 2) = 87;
 *   SQL > SELECT * FROM emp WHERE INSTR(hiredate, '87') = 3;
 *   SQL > SELECT * FROM emp WHERE hiredate LIKE '%87%';
 *   
 *   ex) 직원중 이름이 5글자인 직원을 검색하되 소문자로 출력하시오.
 *   SQL> SELECT empno, LOWER(ename) FROM emp WHERE LENGTH(ename) = 5;
 *   
 *  SYSDATE : 시스템의 현재 날짜
 *   ex) 현재 날짜와 시간을 출력하시오.
 *   SQL > SELECT SYSDATE FROM dual;
 *  MONTHS_BETWEEN : 날짜와 날짜 사이의 개월을 계산
 *   ex) 사원테이블에서 사원번호, 사원이름, 근무개월수를 출력하시오.
 *   SQL > SELECT empno, ename, MONTHS_BETWEEN(SYSDATE, hiredate) FROM emp;
 *  ADD_MONTHS : 날짜에 개월을 더한 날짜 계산
 *   ex) 현재 날짜에서 3개월 후를 출력
 *   SQL > SELECT ADD_MONTHS(SYSDATE, 3) FROM dual;
 *  NEXT_DAY : 날짜후의 첫 요일의 날짜를 계산  ( 1 (일요일), 2 (월요일) ..)
 *   ex) 다음 수요일의 날짜를 출력.
 *   SQL > SELECT NEXT_DAY(SYSDATE, 4) FROM dual;
 *  LAST_DAY : 월의 마지막 날짜를 계산
 *   ex) 이번달의 마지막 날짜를 출력
 *   SQL > SELECT LAST_DAY(SYSDATE) FROM dual;
 *  ROUND : 날짜를 반올림
 *  TRUNC : 날짜를 절삭
 *  
 * 형 변환 함수
 *          <- TO_NUMBER             <- TO_CHAR
 *   Number               Character               Date
 *            TO_CHAR ->              TO_DATE ->
 *            
 * TO_DATE : 문자열을 날짜 형으로 변환
 *  ex) 현재로부터 2006년 01월 01일 의 차이 일수를 출력
 *  SQL > SELECT SYSDATE - TO_DATE('2016/01/01', 'YYYY/MM/DD') FROM dual;
 *  
 * TO_CHAR : 날짜나 숫자형을 문자로 변환
 *  [형식] TO_CHAR(number | date, 'format')
 *   * 형식
 *    YYYY -> 년도 표현 (4자리)
 *    YY -> 년도 표현 (2자리)
 *    MM -> 월을 숫자로 표현
 *    MON -> 월을 알파벳으로 표현
 *    DAY -> 요일 표현
 *    DY -> 요일을 약어로 표현
 *    AM 또는 PM -> 오전 (AM), 오후 (PM) 시각 표시
 *    A.M 또는 P.M -> 오전 (A.M), 오후 (P.M) 시각 표시
 *    HH 또는 HH12 -> 시간 (1~12)
 *    HH24 -> 24시간으로 표현 (0~23)
 *    MI -> 분 표현
 *    SS -> 초 표현
 *    
 *    ex) SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM/DD/YY, HH24-MI-SS') FROM dual;
 *  
 *  NVL 함수 : NULL 값대신 특정 값으로 대치
 *   ex) 사원테이블에서 사원번호, 사원이름, 직업, 상사번호 ( 없을시 CEO로 표시) 하여 출력.
 *   SQL > SELECT empno, ename, job, NVL(TO_CHAR(mgr), 'CEO') FROM emp;
 */
public class Sql {

}
