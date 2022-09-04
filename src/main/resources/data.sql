insert into member(id, nickname, provider, user_key, image_url, created_at, updated_at, deleted_at, refresh_token, fcm_token, password)
values(1, 'tester00', 'KAKAO', 'user-key-00', 'https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/e5d65263-6722-4b84-b839-8d7c3895fc14khh.png', now(), now(), null, null, null, 'test');
insert into member(id, nickname, provider, user_key, image_url, created_at, updated_at, deleted_at, refresh_token, fcm_token, password)
values(2, 'tester01', 'KAKAO', 'user-key-01', 'https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/e5d65263-6722-4b84-b839-8d7c3895fc14khh.png', now(), now(), null, null, null, 'test');

insert into location (id, address1, address2)
VALUES (1, '서울특별시 강남구', '역삼동');
insert into location (id, address1, address2)
VALUES (2, '서울특별시 서초구', '서초동');

insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목0', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.500643, 127.036377, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (2, '제목1', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.497952, 127.027619, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목2', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.4934705, 127.01422, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (2, '제목3', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.49184, 127.007688, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목4', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.500643, 127.036377, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (2, '제목5', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.497952, 127.027619, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목6', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.4934705, 127.01422, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (2, '제목7', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.49184, 127.007688, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목8', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.500643, 127.036377, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (2, '제목9', '내용', 1, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.497952, 127.027619, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목10', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.4934705, 127.01422, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, category_detail, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목11', '내용', 2, 'BANTTANG', 'DIGITAL', null, 1, 'NORMAL', 37.49184, 127.007688, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목12', '내용', 1, 'BEONGAE', null, 1, 'NORMAL', 37.500643, 127.036377, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목13', '내용', 1, 'BEONGAE', null, 1, 'NORMAL', 37.497952, 127.027619, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목14', '내용', 2, 'BEONGAE', null, 1, 'NORMAL', 37.4934705, 127.01422, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목15', '내용', 2, 'BEONGAE', null, 1, 'NORMAL', 37.49184, 127.007688, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목16', '내용', 1, 'BEONGAE', null, 1, 'NORMAL', 37.500643, 127.036377, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목17', '내용', 1, 'BEONGAE', null, 1, 'NORMAL', 37.497952, 127.027619, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목18', '내용', 2, 'BEONGAE', null, 1, 'NORMAL', 37.4934705, 127.01422, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);
insert into deal(member_id, title, content, location_id, category, completed_at, beongae_count, status, trade_latitude, trade_longitude, image_url, price, created_at, updated_at, deleted_at, max_participant, current_participant, dutch_pay)
VALUES (1, '제목19', '내용', 2, 'BEONGAE', null, 1, 'NORMAL', 37.49184, 127.007688, '["https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/d8d13343-e338-4be7-92cc-51f0c5a22db1e1d6a1e6046bf1b6135a5e19d4143683-sticker.png","https://banttang-image.s3.ap-northeast-2.amazonaws.com/image/a43db5b8-9f99-468c-971e-8de50604c076khh.png"]', 40000, now(), now(), null, 4, 2, 10000);

insert into deal_participant(deal_id, member_id, created_at, updated_at, canceled_at, cancel_count)
VALUES(2, 1, now(), now(), null, 0);

