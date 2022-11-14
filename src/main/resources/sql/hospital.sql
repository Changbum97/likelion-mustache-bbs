-- 경기도 수원시의 피부과 검색
SELECT *
FROM `likelion-db`.nation_wide_hospitals
WHERE road_name_address LIKE '경기도 수원시%' AND hospital_name LIKE '%피부과%';

/* 서울특별시의 보건진료소, 보건지소, 보건소 검색 */
SELECT *
FROM `likelion-db`.nation_wide_hospitals
WHERE road_name_address LIKE '서울특별시%'
AND (business_type_name LIKE '%보건진료소%'OR business_type_name LIKE '%보건지소%' OR business_type_name LIKE '%보건소');

/* 서울특별시의 보건진료소, 보건지소, 보건소 검색 - IN 사용 */
SELECT *
FROM `likelion-db`.nation_wide_hospitals
WHERE road_name_address LIKE '서울특별시%'
AND business_type_name IN ('보건진료소', '보건소', '보건지소');