package com.guestbook;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by skyereh on 28.02.17.
 */
public interface GuestbookRepository extends JpaRepository <GuestbookEntry, Long> {
}
