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
 */
public class Sql {

}
