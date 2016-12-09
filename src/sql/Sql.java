package sql;
/*
 * 
 * 2016_12_08
 * 
 * ����Ŭ �⺻ ��Ʈ : 1521
 * NOT NULL : ���� �׻� ���� �Ѵ�.
 * 
 * ��1����ȭ : �����Ϳ� ������ ���� �ʵ���.
 * ��2����ȭ : �ߺ��� �����Ͱ� ��������� �ʵ���.
 * 
 * select * from tab; -> �ش� �����ͺ��̽��� ��� ���̺� ��ȸ.
 * desc ���̺�� -> ���̺��� ������ ��ȸ.
 * 
 * ����Ŭ�� ������ ��
 *  1. NUMBER ������ �� 
 *    NUMBER(precision, scale) -> scale : �Ҽ��� �ڸ� ��
 *  
 *  2. VARCHAR2 ������ ��
 *    ���� ���ڿ� ������ ��
 *     - �����ڴ� �ѱ��ڿ� �Ѱ����� ����
 *     - �ѱ��ڴ� �ѱ��ڿ� �������� ����
 *    
 *  3. DATE ������ ��
 *    ��¥�� ǥ���ϴ� ������ ��
 * 
 * SELECT ��
 *  SELECT [DISTINCT] �÷�, ... FROM ���̺� ��;
 *   
 *   *NULL �� ������ �̴�.
 *    1. 0(zero)�� �ƴϰ�
 *    2. �� ������ �ƴϴ�
 *    3. ��Ȯ��(�ش� ���� ����), �� �� ����(unknown) ���� �ǹ��Ѵ�.
 *    4. � ������ �� �� ������ � ���� �����ϰ� �ִ�.
 *    5. ? Ȥ�� ���Ѵ� �� �ǹ� �̹Ƿ�
 *    6. ����, �Ҵ�, �񱳰� �Ұ��� �ϴ�.
 *    
 * ��Ī
 *  [1] �빮�� �ҹ��ڸ� ���������� ����� ��ҹ��� �������� �ʰ� ���.
 *  SQL > SELECT ename, sal*12+comm Annsal FROM emp;
 *  
 *  [2] ""���̿��� ���鹮��, _, # ��� �����ϸ� ��ҹ��ڰ� ���еǾ� ���.
 *  SQL > SELECT ename, sal*12+comm "A n n s a l" FROM emp;
 *  
 *  [3] �ѱ� ����� �����ϴ�.
 *  SQL > SELECT ename, sal*12+comm "����" FROM emp;
 *  
 *  [4] AS�� ����Ͽ� ��Ī�� �ο��ϴ� ���.
 *  SQL > SELECT ename, sal*12+comm AS Annsal FROM emp;
 *  
 *    * "" -> ��Ī���� �����ϰ� ���.
 *  	'' -> ���ڿ� ǥ���ϴµ� ���.
 *  	
 * Concatenation ( || ) �������� ���ǿ� ���
 *  �÷��� �÷��� ������.
 *  SQL > SELECT ename, 'is a', job FROM emp;
 *  SQL > SELECT enmae || 'is a' || job FROM emp;
 *  
 * DISTINCT Ű����
 *  �ߺ��Ǵ� �����͸� �ѹ��� ������.
 *  SQL > SELECT DISTINCT deptno FROM emp;
 *  
 * WHERE ��
 *  Ư�� �����͸� �����ϱ� ���� ������ ���
 *  SQL > SELECT columns FROM table_name WHERE conditions;
 *  
 *  ex) �μ���ȣ�� 10���� ����� ���� ����
 *   SQL > SELECT * FROM emp WHERE deptno = 10;
 *  ex) �޿��� 2000�̻� �Ǵ� ����� �����ȣ, ����̸�, �޿��� ���
 *   SQL > SELECT * FROM emp WHERE sal >= 2000;
 *  ex) �̸��� FORD �� ����� �����ȣ, ����̸��� ���
 *   SQL > SELECT empno, ename FROM emp WHERE ename = 'FORD';
 *     * ������ ��
 *      -> ���� ����ǥ �ȿ� ���ڿ� �����ʹ� ��ҹ��ڸ� �����ϹǷ� �ҹ��ڷ�
 *         ������� ����ϸ� �ش� �����͸� ã�� ���մϴ�.
 * 
 * �� ������
 *  AND - �� ���� ������ ��� �����ؾ߸� �˻��� �� �ִ�.
 *   ex) �μ���ȣ�� 10�̸鼭 ������ CLERK �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE deptno = 10 AND job = 'CLERK';
 *  OR - �� ���� ���� �߿��� �Ѱ����� �����ϴ��� �˻��� �� �ִ�.
 *   ex) �Ի�⵵�� 1982�� 01�� 01�� ���� �̰ų� ������ MANAGER �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE hiredate >= '1982/01/01' OR job = 'MANAGER';
 *  NOT - ���ǿ� �������� ���ϴ� �͸� �˻��Ѵ�.
 *   ex) �μ���ȣ�� 10���� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE NOT deptno = 10;
 *   SQL > SELECT * FROM emp WHERE deptno <> 10;
 *   ex) �޿��� 2000 ���� 3000 ���̰� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;
 *   ex) Ŀ�̼��� 300�̰ų� 500�̰ų� 1400�� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm NOT IN(300, 500, 1400);
 *   ex) �̸��� A�� ���� �ʴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE ename NOT LIKE '%A%';
 *  IS - NULL �� ���� �Ǻ�
 *   ex) Ŀ�̼��� ���� null �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm IS NULL;
 *   ex) Ŀ�̼��� ���� null �� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm IS NOT NULL;
 * 
 * LIKE ( ���� ó�� ������ )
 *  [����] Column_name like 'pattern'
 *  ex) ��� �̸��� J�� �����ϴ� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE 'J%';
 *  ex) ��� �̸��� N���� ������ ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%N';
 *  ex) ��� �̸��� A�� ���� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%A%';
 *  ex) ��� �̸��� �ι�° ��¥�� A�� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '_A%';
 *  
 *  
 * IN ������
 *  [����] �÷� in(��ȸ ����..)
 *  ex) Ŀ�̼��� 300 �Ǵ� 500 �Ǵ� 1400 �� ����� ���
 *  SQL> SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;
 *  SQL> SELECT * FROM emp WHERE comm IN(300, 500, 1400);
 * 
 * BETWEEN AND ������
 * 
 *  [����] �÷� BETWEEN ���� AND ��
 *  ex) �޿��� 2000 ���� 3000 ������ ����� ���
 *  SQL> SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;
 *  SQL> SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
 *  
 * ORDER BY ( �����Ͽ� ��� )
 *  [����] ORDER BY �÷Ÿ� [ASC | DESC]
 *  ex) �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY sal;
 *  SQL > SELECT * FROM emp ORDER BY sal ASC;
 *  ex) �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY sal DESC;
 *  ex) �μ���ȣ�� �������� �����ϰ� �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY deptno ASC, sal DESC;
 *  
 * DUAL ���̺�
 *  - DAUL ���̺��� SYS ����ڰ� �����ϴ� ������ ��� ����ڰ� ����� �� �ִ�.
 *  - DAUL ���̺��� DUMMY��� �� �ϳ��� �÷����� �����Ǿ� �ֽ��ϴ�. �� �÷�����
 *    ���̰� 1�� ���� �� ���� ������ �� �ִ�.
 * 
 * ROUND (�ݿø�) �Լ�
 *  [����] ROUND(������, �ݿø���ġ)
 *  ex) SELECT ROUND(45.293, 2) FROM dual; -> 45.29
 *  ex) SELECT ROUND(45.277, 2) FROM dual; -> 45.28
 *  ex) SELECT ROUND(45.293, 0) FROM dual; -> 45
 *  ex) SELECT ROUND(45.293, -1) FROM dual; -> 50
 *  
 * TRUNC (����) �Լ�
 *  [����] TRUNC(������, ������ġ)
 *  ex) SELECT TRUNC(45.196, 2) FROM dual; -> 45.19
 *  
 * MOD (������ ���ϴ�) �Լ�
 *  [����] MOD(������, ������)
 *  ex) ��� ���̺��� �����ȣ, ����̸�, �޿��� 100���� ���� �������� ���.
 *  SQL > SELECT empno, ename, sal, MOD(sal, 100) FROM emp;
 *  ex) ������ �߿��� ����� Ȧ���� ����� �˻�
 *  SQL > SELECT * FROM emp WHERE MOD(empno, 2) = 1;
 *  
 * ���� ó�� �Լ�
 *  UPPER : �빮�ڷ� ��ȯ
 *   ex) SELECT UPPER('Welcome to Java') FROM dual; -> WELCOME TO JAVA
 *  LOWER : �ҹ��ڷ� ��ȯ
 *   ex) SELECT LOWER('Welcome to Jave') FROM dual; -> welcome to java
 *  INITCAP : �̴ϼȸ� �빮�ڷ� ��ȯ
 *   ex) SELECT INITCAP('welcome to java') FROM dual; -> Welcome To Java
 *  LENGTH : ���ڿ��� ���̸� ��ȯ
 *   ex) SELECT LENGTH('Welcome to Java') FROM dual; -> 15
 *  INSTR : Ư�����ڰ� �����ϴ� ��ġ�� ��ȯ
 *   ex) ó�� 'o' �����ϴ� �ε����� ��ȯ
 *   SQL > SELECT INSTR('Welcome to Java', 'o') FROM dual -> 5
 *   ex) 6��° ���ڿ����� �����Ͽ� ó�� 'o' ���ڿ��� �����ϴ� ��ġ�� ��ȯ
 *   SQL > SELECT INSTR('Welcome to Java', 'o', 6, 1) FROM dual -> 10
 *   ex) 3���� ���ڿ����� �����Ͽ� �ι�°�� 'o' ���ڿ��� �����ϴ� ��ġ�� ��ȯ
 *   SQL > SELECT INSETR('Welcome to Java', 'o', 3, 2) FROM dual -> 10
 *   ex) ����� �̸��߿��� A ���ڰ� ���°�� ����ϴ��� �����÷����� ���
 *   SQL > SELECT ename, INSTR(ename, 'A') FROM emp;
 *  SUBSTR : ������ �Ϻκ��� ��ȯ
 *   ex) �ش� ���ڿ����� 4��° ���� ���� 4���� ���ڿ��� ��ȯ
 *   SQL > SELECT SUBSTR('Welcome to Java', 4, 4) -> come
 *   ex) ����� �̸��� ����� �Ի�⵵���� ���
 *   SQL > SELECT SUBSTR(hiredate, 1, 4) FROM emp;
 *  LPAD : ������ ���� �� ���ʿ� ���� �� ���鿡 Ư�� ���ڸ� ä���.
 *   ex) 'javadori' ���ڿ��� ���ʿ� # ���ڷ� 20���� ä�� ���
 *   SQL > SELECT LPAD('javadori', 20, '#') FROM dual;
 *  RPAD : ���� ���� �� �����ʿ� ���� �� ���鿡 Ư�� ���ڸ� ä���.
 *   ex) 'javadori' ���ڿ��� �����ʿ� # ���ڷ� 20���� ä�� ���
 *   SQL > SELECT RPAD('javadori', 20, '#') FROM dual;
 *  LTRIM : ���ʿ��� Ư�� ���ڸ� �����Ѵ�.
 *   ex) 'aaaaaajavadoriaaaaaaa' ���� ���ʿ��� 'a' ���ڸ� �����Ͽ� ���
 *   SQL > SELECT LTRIM('aaaaaajavadoriaaaaaaa', 'a') FROM dual;
 *   ex) '     javadori     ' ���� ���ʿ��� ������ �����Ͽ� ���
 *   SQL > SELECT LTRIM('     javadori     ') FROM dual;    
 *  RTRIM : �����ʿ��� Ư�� ���ڸ� �����Ѵ�.
 *   ex) 'aaaaaajavadoriaaaaaaa' ���� �����ʿ��� 'a' ���ڸ� �����Ͽ� ���
 *   SQL > SELECT RTRIM('aaaaaajavadoriaaaaaaa', 'a') FROM dual;
 *   ex) '     javadori     ' ���� �����ʿ��� ������ �����Ͽ� ���
 *   SQL > SELECT RTRIM('     javadori     ') FROM dual; 
 *  TRIM : ���ʿ��� ������ �����Ѵ�.
 *   ex)  '     javadori     ' ���� ������ ������ �����Ͽ� ���
 *   SQL > SELECT TRIM('     javadori     ') FROM dual;
 * 
 *  �ǽ� ����)
 *   ex) �̸��� ����° �ڸ��� R�� ����� �˻��Ͻÿ�.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, 3, 1) = 'R';
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'R', 3, 1) = 3;
 *   SQL > SELECT * FROM emp WHERE WHERE ename LIKE '__R%';
 *   
 *   ex) �̸��� �� �ڸ��� N���� ������ ����� �˻��Ͻÿ�.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, LENGTH(ename), 1) = 'N';
 *   SQL > SELECT * FROM emp WHERE SUBSTR(ename, -1, 1) = 'N';
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'N') = LENGTH(ename);
 *   SQL > SELECT * FROM emp WHERE INSTR(ename, 'N', LENGTH(ename), 1) = LENGTH(ename);
 *   SQL > SELECT * FROM emp WHERE ename LIKE '%R';
 *   
 *   ex) 87�⵵�� �Ի��� ������ �˻��Ͻÿ�.
 *   SQL > SELECT * FROM emp WHERE SUBSTR(hiredate, 3, 2) = '87';
 *   SQL > SELECT * FROM emp WHERE SUBSTR(hiredate, 3, 2) = 87;
 *   SQL > SELECT * FROM emp WHERE INSTR(hiredate, '87') = 3;
 *   SQL > SELECT * FROM emp WHERE hiredate LIKE '%87%';
 *   
 *   ex) ������ �̸��� 5������ ������ �˻��ϵ� �ҹ��ڷ� ����Ͻÿ�.
 *   SQL> SELECT empno, LOWER(ename) FROM emp WHERE LENGTH(ename) = 5;
 *   
 *  SYSDATE : �ý����� ���� ��¥
 *   ex) ���� ��¥�� �ð��� ����Ͻÿ�.
 *   SQL > SELECT SYSDATE FROM dual;
 *  MONTHS_BETWEEN : ��¥�� ��¥ ������ ������ ���
 *   ex) ������̺��� �����ȣ, ����̸�, �ٹ��������� ����Ͻÿ�.
 *   SQL > SELECT empno, ename, MONTHS_BETWEEN(SYSDATE, hiredate) FROM emp;
 *  ADD_MONTHS : ��¥�� ������ ���� ��¥ ���
 *   ex) ���� ��¥���� 3���� �ĸ� ���
 *   SQL > SELECT ADD_MONTHS(SYSDATE, 3) FROM dual;
 *  NEXT_DAY : ��¥���� ù ������ ��¥�� ���  ( 1 (�Ͽ���), 2 (������) ..)
 *   ex) ���� �������� ��¥�� ���.
 *   SQL > SELECT NEXT_DAY(SYSDATE, 4) FROM dual;
 *  LAST_DAY : ���� ������ ��¥�� ���
 *   ex) �̹����� ������ ��¥�� ���
 *   SQL > SELECT LAST_DAY(SYSDATE) FROM dual;
 *  ROUND : ��¥�� �ݿø�
 *  TRUNC : ��¥�� ����
 *  
 * �� ��ȯ �Լ�
 *          <- TO_NUMBER             <- TO_CHAR
 *   Number               Character               Date
 *            TO_CHAR ->              TO_DATE ->
 *            
 * TO_DATE : ���ڿ��� ��¥ ������ ��ȯ
 *  ex) ����κ��� 2006�� 01�� 01�� �� ���� �ϼ��� ���
 *  SQL > SELECT SYSDATE - TO_DATE('2016/01/01', 'YYYY/MM/DD') FROM dual;
 *  
 * TO_CHAR : ��¥�� �������� ���ڷ� ��ȯ
 *  [����] TO_CHAR(number | date, 'format')
 *   * ����
 *    YYYY -> �⵵ ǥ�� (4�ڸ�)
 *    YY -> �⵵ ǥ�� (2�ڸ�)
 *    MM -> ���� ���ڷ� ǥ��
 *    MON -> ���� ���ĺ����� ǥ��
 *    DAY -> ���� ǥ��
 *    DY -> ������ ���� ǥ��
 *    AM �Ǵ� PM -> ���� (AM), ���� (PM) �ð� ǥ��
 *    A.M �Ǵ� P.M -> ���� (A.M), ���� (P.M) �ð� ǥ��
 *    HH �Ǵ� HH12 -> �ð� (1~12)
 *    HH24 -> 24�ð����� ǥ�� (0~23)
 *    MI -> �� ǥ��
 *    SS -> �� ǥ��
 *    
 *    ex) SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM/DD/YY, HH24-MI-SS') FROM dual;
 *  
 *  NVL �Լ� : NULL ����� Ư�� ������ ��ġ
 *   ex) ������̺��� �����ȣ, ����̸�, ����, ����ȣ ( ������ CEO�� ǥ��) �Ͽ� ���.
 *   SQL > SELECT empno, ename, job, NVL(TO_CHAR(mgr), 'CEO') FROM emp;
 */
public class Sql {

}
